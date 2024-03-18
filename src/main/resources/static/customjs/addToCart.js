

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
getCartTotalItem();

let cartId = 0;
let quantity = 1;
function buyAction(itemCode,price) {

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