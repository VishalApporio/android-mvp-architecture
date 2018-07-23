
package com.tukin.user.mvp.data.db.model.orderHistory;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("Completed_Orders")
    @Expose
    private List<CompletedOrder> completedOrders = null;
    @SerializedName("Ongoing_Orders")
    @Expose
    private List<OngoingOrder> ongoingOrders = null;

    public List<CompletedOrder> getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(List<CompletedOrder> completedOrders) {
        this.completedOrders = completedOrders;
    }

    public List<OngoingOrder> getOngoingOrders() {
        return ongoingOrders;
    }

    public void setOngoingOrders(List<OngoingOrder> ongoingOrders) {
        this.ongoingOrders = ongoingOrders;
    }

}
