package co.bagga.pikedesk.Network;

/**
 * Created by bagga on 2017-07-13.
 */

/***
 * Callback to be called after http call for an endpoint
 */
public interface HttpCallBack {
    /***
     * Method to be called after a successful HTTP request
     *
     * @param response response for the HTTP request issued
     * @param responseCode response code for the HTTP request issued
     */
    void onHttpRequestSuccess(String response, int responseCode);

    /***
     * Method to be called after a failed HTTP request
     *
     * @param response response for the HTTP request issued
     * @param responseCode response code for the HTTP request issued
     */
    void onHttpRequestError(String response, int responseCode);
}
