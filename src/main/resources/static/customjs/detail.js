const urlLocation = window.location.search;
const urlParams = new URLSearchParams(urlLocation);

let itemCodeGlobal = urlParams.get('code');

function getProductDetailAPI(itemCode) {
	var settings = {
		"url": "/api/product/detail?item_code=" + itemCode,
		"method": "GET",
		"timeout": 0,
		async: false
	};

	return $.ajax(settings);
}

function showProductDetail() {
	const response = getProductDetailAPI(itemCodeGlobal).responseJSON;
	if (response.code == 200) {
		const data = response.data;
		$("#product-detail").html(`
			<div class="row g-0">
				<div class="col-md-5">
					<img src="${data.image_path}" class="img-fluid rounded-start w-100" alt="...">
				</div>
				<div class="col-md-7">
					<div class="card-body">
						<h4 class="card-title">${data.product_name}</h4>
						<p class="card-text"><small class="text-muted">Kategori : ${data.product_type}</small></p>
						<h5 class="card-text">Harga : ${data.price}</h5>
						<p class="card-text mb-0">Kode : ${data.item_code}</p>
						<p class="card-text mb-0">Stok : ${data.quantity}</p>
						<hr>
						<div class="input-group mb-3 w-25">
						  <button id="minus-btn" class="btn btn-secondary" type="button">-</button>
						  <input type="text" class="form-control" placeholder="1" aria-label="0">
						  <button id="plus-btn" class="btn btn-secondary" type="button">+</button>
						</div>
						<div class="">
							<a href="#" class="btn btn-dark"><i class="fa-solid fa-cart-shopping"></i> Buy</a>
						</div>
					</div>
				</div>
			</div>
		`);
	}
}
showProductDetail();
