const urlLocation = window.location.search;
const urlParams = new URLSearchParams(urlLocation);

let productIdGlobal = urlParams.get('product_id');

