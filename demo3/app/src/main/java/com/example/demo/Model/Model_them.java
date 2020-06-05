package com.example.demo.Model;

import com.example.demo.ConnectInternet.DownloadJSON;
import com.example.demo.MainActivity;
import com.example.demo.Model.ObjectClass.hocsinh;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Model_them {
    public Boolean Them(hocsinh hocsinh){
        boolean kiemtra=false;
        List<HashMap<String, String>> attrs=new ArrayList<>();
        String duongdan= MainActivity.SERVER_NAME;

        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham","ThemHocSinh");

        HashMap<String,String> hsName = new HashMap<>();
        hsName.put("name",hocsinh.getName());

        HashMap<String,String> hsMark = new HashMap<>();
        hsMark.put("mark",String.valueOf(hocsinh.getMark()));

        attrs.add(hsHam);
        attrs.add(hsName);
        attrs.add(hsMark);
        DownloadJSON downloadJSON=new DownloadJSON(duongdan, attrs);
        downloadJSON.execute();
        try {
            String dataJSON = downloadJSON.get();
            JSONObject jsonObject= new JSONObject(dataJSON);
            String ketqua=jsonObject.getString("ketqua");
            if(ketqua.equals("true")){
                kiemtra = true;
            }
            else {
                kiemtra = false;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return kiemtra;
    }
}
