package id.bootcamp.pembekalan2024.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Resp<T> {

	private Integer code;
	private String message;
	private Integer total_data;
	private Integer total_page;
	private T data;

	public Integer getTotal_data() {
		return this.total_data;
	}

	public void setTotal_data(Integer total_data) {
		this.total_data = total_data;
	}

	public Integer getTotal_page() {
		return this.total_page;
	}

	public void setTotal_page(Integer total_page) {
		this.total_page = total_page;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
