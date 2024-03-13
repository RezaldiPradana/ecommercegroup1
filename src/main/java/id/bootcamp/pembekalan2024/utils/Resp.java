package id.bootcamp.pembekalan2024.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

//Generic Class
@JsonInclude(JsonInclude.Include.NON_NULL) //tidak menampilkan data yang null
public class Resp<T> {
    private Integer code;
    private String message;
    private T data;

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
