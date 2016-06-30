$(document).ready(function() {

    function reportResponse(res) {
        $("textarea#serverResponse").val(res);
    }

    // Light click handler
    $("#light").on("click", function() {

        $.ajax("/api/light", {
            dataType: "text",
            success: function(data) {
                reportResponse(data);
            }
        });

    });



    // Door click handler
    $("#door").on("click", function() {

        $.ajax("/api/door", {
            dataType: "text",
            success: function(data) {
                reportResponse(data);
            }
        });

    });



    // Sensor click handler
    $("#sensor").on("click", function() {

        $.ajax("/api/sensor", {
            dataType: "text",
            success: function(data) {
                reportResponse(data);
            }
        });

    });



    // Health check click handler
    $("#health").on("click", function() {

        $.ajax("/api/health", {
            dataType: "text",
            success: function(data, textStatus) {
                reportResponse(data);
            }
        });

    });
});