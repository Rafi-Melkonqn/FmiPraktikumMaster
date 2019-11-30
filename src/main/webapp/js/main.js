$("#searchBtn").click(function(e){
    var name = $("#name").val();
    var type = $("#type").val();
    var model = $("#model").val();

    $.ajax({
        method: "GET",
        url: "model",
        data: {
            name: name,
            type: type,
            model: model
        }
    })
        .done(function(response){
            var $results = $("#results");
            $results.html("");
            $results.removeClass("bg-warning");
            $results.addClass("bg-info mt-5");
            for (i in response){
            	alert("for");
                $results.append('<div class="text-white p-3">'+
                    '<div class="result-content"><span class="font-weight-bold">Превозното средство :</span> '+response[i].type+'</div>'+
                    '<div class="result-content"><span class="font-weight-bold">Марка:</span> '+response[i].name+'</div>'+
                    '<div class="result-content"><span class="font-weight-bold">Модел:</span> '+response[i].model+'</div>'+
                    '</div>');
            }
            $(".result-content").addClass("bg-primary p-4");
        })
        .fail(function(){
        	alert("fail");
            var $results = $("#results");
            $results.html("");
            $results.removeClass("bg-info");
            $results.addClass("bg-warning p-3 mt-5");
            $results.append('<div class="font-weight-bold">Няма открити Превозни средства!</div>');
        });
});

$("#toggleBtn").click(function(){
    var $results = $(".result-content");
    var display = $results.css("display");
    if (display == "block") {
        $results.css("display", "inline-block");
    } else if (display == "inline-block") {
        $results.css("display", "block");
    }
});