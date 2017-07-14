package co.bagga.pokedesk.Network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by bagga on 2017-07-13.
 */

public class RequestGenerator {
    private static Context context;
    private static final RequestGenerator ourInstance = new RequestGenerator();

    public static RequestGenerator getInstance(Context context) {
        RequestGenerator.context = context;
        return ourInstance;
    }

    private RequestGenerator() {
    }

    public void generatePokemonIdentityRequest(int id, final HttpCallBack httpCallBack) {
        VolleyRequest.getInstance(context).addToVolleyRequestQueue(new JsonObjectRequest(Request.Method.GET, UrlBuilder.buildPokeUrlByPokemonId(id),
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                httpCallBack.onHttpRequestSuccess(response.toString(), 200);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                httpCallBack.onHttpRequestError(error.toString(), 400);
            }
        }));
    }

    public void generatePokemonDescriptionByUrl(String url, final HttpCallBack httpCallBack) {
        VolleyRequest.getInstance(context).addToVolleyRequestQueue(new JsonObjectRequest(Request.Method.GET, UrlBuilder.getBaseUrl() + url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                httpCallBack.onHttpRequestSuccess(response.toString(), 200);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                httpCallBack.onHttpRequestError(error.toString(), 400);
            }
        }));
    }
}
