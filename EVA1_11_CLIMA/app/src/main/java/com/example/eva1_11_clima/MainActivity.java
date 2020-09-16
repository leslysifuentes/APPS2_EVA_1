package com.example.eva1_11_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv_clima;
    List<Weather> lista_ciudades = new ArrayList<>();
 /*   Weather[] ciudades = {new Weather("Chihuahua", 20, "Nublado", R.drawable.light_rain),
            new Weather("Satevo", 20, "Nublado", R.drawable.light_rain),
            new Weather("Delicias", -5, "Despejado", R.drawable.sunny),
            new Weather("Cd. Juárez", -3, "Nevadas intensas", R.drawable.snow),
            new Weather("Jimenez", 19, "Lluvias intensas", R.drawable.rainy),
            new Weather("Camargo", 5, "Niebla", R.drawable.cloudy),
            new Weather("Parral", 9, "Nevado", R.drawable.snow),
            new Weather("Aldama", 25, "Despejado", R.drawable.atmospher),
            new Weather("Batoplilas", -12, "Despejado", R.drawable.sunny),
            new Weather("Creel", 16, "Nublado", R.drawable.light_rain),
            new Weather("Casas Grandes", 0, "Lluvias intensas", R.drawable.tornado) };

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_clima = findViewById(R.id.lv_clima);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=439d4b804bc8187953eb36d2a8c26a02",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("list");
                            for(int i=0; i< jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Weather w_ciudad = new Weather();
                                w_ciudad.setCiudad(jsonObject.getString("name"));

                                JSONObject jsMain = jsonObject.getJSONObject("main");
                                w_ciudad.setTemperatura((int)jsMain.getDouble("temp"));

                                JSONArray ja_clima = jsonObject.getJSONArray("weather");
                                JSONObject jo_clima_ciudad = ja_clima.getJSONObject(0);
                                w_ciudad.setDescripcion(jo_clima_ciudad.getString("description"));
                                int id = jo_clima_ciudad.getInt("id");
                                if(id <300){//tormenta
                                    w_ciudad.setImagen(R.drawable.thunderstorm);
                                }
                                else if(id<400){//lluvia ligera
                                    w_ciudad.setImagen(R.drawable.light_rain);
                                }
                                else if(id<600){//lluvia intensa
                                    w_ciudad.setImagen(R.drawable.rainy);
                                }
                                else if(id<700){//nieve
                                    w_ciudad.setImagen(R.drawable.snow);
                                }
                                else if(id<801){//despejado
                                    w_ciudad.setImagen(R.drawable.sunny);
                                }
                                else if(id<900){//nublado
                                    w_ciudad.setImagen(R.drawable.cloudy);
                                }
                                else {
                                    w_ciudad.setImagen(R.drawable.thunderstorm);
                                }
                                lista_ciudades.add(w_ciudad);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //se conecta el adapter a los datos
                        lv_clima.setAdapter(new WeatherAdapter(MainActivity.this,
                                R.layout.mi_layout,lista_ciudades));
                    }
                },

                new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );

        Volley.newRequestQueue(this).add(jsonObjectRequest);

     //   lv_clima.setAdapter(new WeatherAdapter(this,R.layout.mi_layout, ciudades));





    }
}
