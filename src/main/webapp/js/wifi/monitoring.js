/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#moni-data",
        data: {
            moniList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiMonitoringData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.moniList = data;

                },
                error: function () {

                }
            });
        }
    });
});
