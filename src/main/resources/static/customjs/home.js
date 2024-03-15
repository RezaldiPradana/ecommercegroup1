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
			$("#row-product").append(`
			<div class="col">
				<div class="card text-center">
					<img src="${data.image_path}"
						class="card-img-top ratio ratio-1x1" alt="...">
					<div class="card-body">
						<h5 class="card-title">${data.product_name}</h5>
						<p class="card-text">${data.price}</p>
						<div class="row">
							<div class="col-6">
								<a href="/product?code=${data.item_code}" class="btn btn-secondary w-100">Detail</a>
							</div>
							<div class="col-6">
								<button id="buy-button" class="btn btn-dark w-100">Buy</button>
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
getCartTotalItem();
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

function isCartExistsAPI(userId) {
	var settings = {
		"url": "/api/cart/isExists?user_id=" + userId,
		"method": "GET",
		"timeout": 0,
		async: false
	};

	return $.ajax(settings);
}
function insertNewCart(respBody) {
	var settings = {
		"url": "/api/cart/new",
		"method": "POST",
		"timeout": 0,
		"headers": {
			"Content-Type": "application/json"
		},
		"data": respBody,
		async: false
	};

	return $.ajax(settings);
}
function insertCartDetail(respBody) {
	var settings = {
		"url": "/api/cart/detail",
		"method": "POST",
		"timeout": 0,
		"headers": {
			"Content-Type": "application/json"
		},
		"data": respBody,
		async: false
	};

	return $.ajax(settings);
}
function getCartByUserAPI(userId) {
	var settings = {
		"url": "/api/cart/id?user_id=" + userId,
		"method": "GET",
		"timeout": 0,
		async: false
	};

	return $.ajax(settings);
}
function getCartTotalItemAPI(userId) {
	var settings = {
		"url": "/api/cart/total-product?user_id=" + userId,
		"method": "GET",
		"timeout": 0,
		async: false
	};

	return $.ajax(settings);
}

function getCartTotalItem() {
	const response = getCartTotalItemAPI(userIdGlobal).responseJSON;
	console.log(response)
	if (response.code == 200) {
		if (response.data > 0) {
			console.log("total")
			$('#cart-shop').html(`
			<span
			class="position-absolute top-25 start-0 translate-middle badge rounded-pill bg-danger">
				<small>${response.data}</small>
			</span>
			`)
		}
	}
}

let cartId = 0;
$('#buy-button').click(function() {

	const resExists = isCartExistsAPI(userIdGlobal).responseJSON;
	if (resExists.data == false) {
		const data = {
			user_id: userIdGlobal
		}
		dataJSON = JSON.stringify(data);
		const responseCart = insertNewCart(dataJSON).responseJSON;
		if (responseCart.code == 200) {
			const respCartId = getCartByUserAPI(userIdGlobal).responseJSON;
			if (respCartId.code == 200) {
				cartId = respCartId.data.id_cart;
			}
		}
	} else {
		const respCartId = getCartByUserAPI(userIdGlobal).responseJSON;
		if (respCartId.code == 200) {
			cartId = respCartId.data.id_cart;
		}
	}

	const dataDetail = {
		id_user: userIdGlobal,
		id_cart: cartId,
		item_code: "CLN001",
		price: 150000,
		quantity: 1
	}
	dataJSON = JSON.stringify(dataDetail);
	const respDetail = insertCartDetail(dataJSON).responseJSON;
	if (respDetail.code == 200) {

	}

})
