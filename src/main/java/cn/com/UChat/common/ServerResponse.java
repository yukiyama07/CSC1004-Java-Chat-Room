package cn.com.UChat.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

// server response
@Data
public class ServerResponse {
    Integer code;
    String message;
    Object data;

    // Constructor
    public static ServerResponse getInstance() {
        return new ServerResponse();
    }

    // Setters
    public ServerResponse code(Integer code) {
        this.code = code;
        return (ServerResponse) this;
    }

    // Setters
    public  ServerResponse message(String message){
        this.message = message;
        return (ServerResponse) this;
    }

    // Setters
    public  ServerResponse data(Object data){
        this.data = data;
        return (ServerResponse) this;
    }

    // Takes ResponseEnum as parameter and set code and message
    public  ServerResponse responseEnum(ResponseEnum responseEnum){
        this.code = responseEnum.code;
        this.message = responseEnum.message;
        return (ServerResponse) this;
    }

    // return JSON formatted string
    @Override
    public String toString() {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", this.code);
        resultJson.put("message", this.message);
        resultJson.put("data", this.data);
        return resultJson.toString();
    }

    // Test
    public static void main(String[] args) {
        System.out.println(ServerResponse.getInstance().responseEnum(ResponseEnum.LOGIN_SUCCESS));
    }

}
