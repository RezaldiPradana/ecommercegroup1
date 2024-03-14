function modalCart() {
	modal = new bootstrap.Modal($('#modalCart'));
	modal.toggle()
	$('#kosong').html('')
	$('#price').html(`<h4>Total Price :</h4>
						<h4 id="totalPrice">20000</h4>`)
	$('#checkout').attr("disabled", false)
	resetData()
}
function modalLoading(){
	modal.toggle()
	modal = new bootstrap.Modal($('#modalLoading'));
	modal.toggle()
	$('#title-loading').html('Loading')
	$('#circle-spinner').html('<div class="spinner"></div>')
	$('#button-close').html('')
	$('#centang').html('')
	setTimeout(kirimData, 2000);
}
//global variable
const user_id = 2
//api
function getAllDetailCartAPI(userId) {
	var form = new FormData();
	form.append("user_id", userId);

	var settings = {
		"url": "/api/cart_detail",
		"method": "POST",
		"timeout": 0,
		"processData": false,
		"mimeType": "multipart/form-data",
		"contentType": false,
		"data": form,
		async : false
	};

	return $.ajax(settings)
}
function resetData(){
	let totalPrice = 0
	let totalItem = 0
	const res = getAllDetailCartAPI(user_id).responseText
	const response = JSON.parse(res)
	if(response.data.length >0){
		const dataList = response.data
		$('tbody').html('')
				for (i = 0; i < dataList.length; i++) {
					const data = dataList[i]
					let total = data.price*data.quantity
					totalPrice +=total
					totalItem +=1
					$('tbody').append(
					`
					<tr>
						<td>${data.product_name}</td>
						<td>${data.quantity}</td>
						<td>${data.price}</td>
						<td>${total}</td>
					</tr>
					`
					)
		}
		$('#item').html(`${totalItem} item`)
		$('#totalPrice').html(`Rp. ${totalPrice}`)
	}
	else {
		$('#price').html('')
		$('#kosong').html('<h2 class="text-center">Anda Belum Memilih Barang!!!</h2>')
		$('#checkout').attr("disabled", true)
	}
}

$('#checkout').click(function() {
	modalLoading()
})

function kirimData(){
	$('#title-loading').html('<i class="fa-solid fa-circle-check fa-6x"></i>')
	$('#centang').html('SUKSES')
	$('#circle-spinner').html('<h4>Pembelian Sudah Berhasil Dilakukan!!!</h4>')
	$('#button-close').html('<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>')
}