const urlLocation = window.location.search;
const urlParams = new URLSearchParams(urlLocation);

let itemCodeGlobal = urlParams.get('code');
let userIdGlobal = 3;

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
		const formattedPrice = new Intl.NumberFormat('id-ID', {minimumFractionDigits: 0, style: 'currency', currency: 'IDR'}).format(data.price);
		$("#product-detail").html(`
			<div class="row g-0">
				<div class="col-md-5">
					<img src="${data.image_path}" class="img-fluid rounded-start w-100" alt="...">
				</div>
				<div class="col-md-7">
					<div class="card-body">
						<h4 class="card-title">${data.product_name}</h4>
						<p class="card-text"><small class="text-muted">Kategori : ${data.product_type}</small></p>
						<h5 class="card-text">Harga : ${formattedPrice}</h5>
						<p class="card-text mb-0">Kode : ${data.item_code}</p>
						<p class="card-text mb-0">Stok : ${data.quantity}</p>
						<p class="card-text mb-0">Deskripsi : ${data.description}</p>
						<hr>
						<div class="input-group mb-3 w-25">
						  <button id="minus-btn" class="btn btn-secondary" type="button">-</button>
						  <input id="qty" type="text" class="form-control" aria-label="0">
						  <button id="plus-btn" class="btn btn-secondary" type="button">+</button>
						</div>
						<div class="">
							<button onclick="buyAction('${data.item_code}',${data.price})" class="btn btn-dark"><i class="fa-solid fa-cart-shopping"></i> Buy</button>
						</div>
					</div>
				</div>
			</div>
		`);
		$('#qty').val(1);
	}
}
showProductDetail();
getCartTotalItem();

$('#plus-btn').on('click', function() {
	const lastQty = parseInt($('#qty').val());
	$('#qty').val(lastQty+1);
});
$('#minus-btn').on('click', function() {
	const lastQty = parseInt($('#qty').val());
	if(lastQty > 1) {
		$('#qty').val(lastQty-1);
	}
});

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
			$('#cart-shop').html(`
			<span
			class="position-absolute top-25 start-0 translate-middle badge rounded-pill bg-danger">
				<small>${response.data}</small>
			</span>
			`)
		}
	}
}

function buyAction(itemCode,price) {
	const quantity = $('#qty').val();

	const resExists = isCartExistsAPI(userIdGlobal).responseJSON;
	if (resExists.data == false) {
		const data = {
			id_user: userIdGlobal
		}
		console.log("cek")
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
		item_code: itemCode,
		price: price,
		quantity: quantity
	}
	dataJSON = JSON.stringify(dataDetail);
	const respDetail = insertCartDetail(dataJSON).responseJSON;
	if (respDetail.code == 200) {
		getCartTotalItem();
	}

};
