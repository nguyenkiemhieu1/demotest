package com.example.demo.Model;

import android.text.Layout;

import com.example.demo.MainActivity;
import com.example.demo.Model.ObjectClass.hocsinh;
import com.example.demo.ConnectInternet.DownloadJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Model_hocsinh {

    public List<hocsinh> LayDanhSachHocSinh(String tenham, String tenmang, int mahs ){
        List<hocsinh> hocsinhList = new ArrayList<>();



        List<HashMap<String, String>> attrs=new ArrayList<>();
        String dataJSON="";
        String duongdan= MainActivity.SERVER_NAME;

        HashMap<String , String > hsHam= new HashMap<>();
        hsHam.put("ham", tenham );

        HashMap<String , String > hsMaHS= new HashMap<>();
        hsMaHS.put("mahocsinh", String.valueOf(mahs));

        attrs.add(hsHam);
        attrs.add(hsMaHS);
        DownloadJSON downloadJSON= new DownloadJSON(duongdan, attrs);

        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);

            JSONArray danhsachHocsinh =jsonObject.getJSONArray(tenmang);

            int dem = danhsachHocsinh.length();
            for(int i = 0; i < dem; i++){
                hocsinh hocsinh = new hocsinh();
                JSONObject jsonObject1 = danhsachHocsinh.getJSONObject(i);
                hocsinh.setID(jsonObject1.getInt("MAHOCSINH"));
                hocsinh.setName(jsonObject1.getString("NAME"));
                hocsinh.setMark(jsonObject1.getInt("MARK"));

                hocsinhList.add(hocsinh);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return hocsinhList;
    }
}
