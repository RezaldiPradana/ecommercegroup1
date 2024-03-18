function getAllProductAPI() {
	var settings = {
		"url": "/api/product",
		"method": "GET",
		"timeout": 0,
		async: false
	};

	return $.ajax(settings);
}

let dataListOri = [];
let dataList = [];
let userIdGlobal = 3;

function showProductList(page) {
	if (page == null) {
		page = 1
	}
	const keyword = $("#input-search").val();

	const response = getAllProductAPI().responseJSON;
	if (response.code == 200) {
		console.log(response.code)
		dataListOri = response.data;
		dataList = searchFE(dataListOri, keyword);
		dataList = paginationFE(dataList, page);
		$("#row-product").html("");
		for (i = 0; i < dataList.length; i++) {
			const data = dataList[i];
			const formattedPrice = new Intl.NumberFormat('id-ID', {minimumFractionDigits: 0, style: 'currency', currency: 'IDR'}).format(data.price);
			$("#row-product").append(`
			<div class="col">
				<div class="card text-center">
					<img src="${data.image_path}"
						class="card-img-top w-100" alt="..."
						style="object-fit: cover; aspect-ratio: 1/1;">
					<div class="card-body">
						<h5 class="card-title">${data.product_name}</h5>
						<p class="card-text">${formattedPrice}</p>
						<div class="row">
							<div class="col-6">
								<a href="/product?code=${data.item_code}" class="btn btn-secondary w-100">Detail</a>
							</div>
							<div class="col-6">
								<button onclick="buyAction('${data.item_code}',${data.price})" class="btn btn-dark w-100">Buy</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			`)
		}
	}
}

//if($("#input-search").val() == '') {
showProductList();

//}

$('#submit-search').on('click', function() {
	showProductList();
})

function searchFE(list, keyword) {
	list = list.filter(data =>
		data.product_name.toLowerCase().includes(keyword.toLowerCase()) ||
		data.product_type.toLowerCase().includes(keyword.toLowerCase())
	)

	return list;
}
function paginationFE(list, page) {
	const limit = 6;
	const total_data = list.length;
	const tpage = (total_data + (limit - (total_data % limit))) / limit;
	const total_page = Math.ceil(list.length / limit.toFixed(2));
	console.log(tpage);
	resetPaginationUI(page, total_data, total_page);

	// potong data
	list = list.slice(limit * (page - 1), limit * page);

	return list;
}
function resetPaginationUI(page, total_data, total_page) {
	$('#pagination-container').html('');
	$('#pagination-container').append(
		`<li class="page-item ${page == 1 ? 'disabled' : ''}">
					<a class="page-link " 
						href="javascript:showProductList(${page - 1})">
							Previous
					</a>
				</li>`
	)

	for (i = 0; i < total_page; i++) {
		$('#pagination-container').append(`
					<li class="page-item ${(i + 1) == page ? 'active' : ''}">
						<a class="page-link"
							href="javascript:showProductList(${i + 1})">
							${i + 1}
						</a>
					</li>
				`)
	}

	$('#pagination-container').append(
		`<li class="page-item ${page == total_page ? 'disabled' : ''}">
					<a class="page-link " 
						href="javascript:showProductList(${page + 1})">
							Next
					</a>
				</li>`
	)
}

