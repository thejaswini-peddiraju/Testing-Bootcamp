/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 96.0, "KoPercent": 4.0};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.836, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.0, 500, 1500, ""], "isController": false}, {"data": [0.75, 500, 1500, "HTTP Request -  componenetReference"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request- purchase"], "isController": false}, {"data": [0.5, 500, 1500, "HTTP Request- calculators"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - formulas"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - login"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - cart"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - fish"], "isController": false}, {"data": [0.95, 500, 1500, "HTTP Request- currencies"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - usermanual"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - propertiesReference"], "isController": false}, {"data": [0.0, 500, 1500, "HTTP Request - Home"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - Batches"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - confirmation"], "isController": false}, {"data": [0.8, 500, 1500, "HTTP Request - changes"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - addToCart"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - charts"], "isController": false}, {"data": [0.95, 500, 1500, "HTTP Request - udemy"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - practice"], "isController": false}, {"data": [0.55, 500, 1500, "HTTP Request  - vacation"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - converters"], "isController": false}, {"data": [0.5, 500, 1500, "HTTP Request - signin"], "isController": false}, {"data": [0.9, 500, 1500, "HTTP Request - choose flight"], "isController": false}, {"data": [1.0, 500, 1500, "HTTP Request - courses"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 250, 10, 4.0, 411.99199999999996, 0, 2332, 260.0, 1056.3000000000002, 1388.5499999999995, 2277.5000000000005, 57.077625570776256, 5609.692048373287, 7.903913384703197], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["", 10, 10, 100.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 33.11258278145696, 27.90640521523179, 0.0], "isController": false}, {"data": ["HTTP Request -  componenetReference", 10, 0, 0.0, 486.80000000000007, 221, 676, 491.0, 674.3, 676.0, 676.0, 11.890606420927467, 13954.780859839477, 1.823071492271106], "isController": false}, {"data": ["HTTP Request- purchase", 10, 0, 0.0, 411.79999999999995, 371, 466, 414.0, 462.40000000000003, 466.0, 466.0, 14.727540500736376, 96.57757271723122, 1.8697072901325478], "isController": false}, {"data": ["HTTP Request- calculators", 10, 0, 0.0, 1229.9, 1060, 1440, 1195.0, 1437.0, 1440.0, 1440.0, 5.202913631633715, 245.4667582596254, 0.6960929370447451], "isController": false}, {"data": ["HTTP Request - formulas", 10, 0, 0.0, 249.3, 240, 263, 249.0, 262.3, 263.0, 263.0, 12.919896640826872, 292.22434189276487, 1.842094638242894], "isController": false}, {"data": ["HTTP Request - login", 10, 0, 0.0, 403.8, 387, 423, 403.0, 422.6, 423.0, 423.0, 14.367816091954023, 80.61972431752874, 1.7258216594827587], "isController": false}, {"data": ["HTTP Request - cart", 10, 0, 0.0, 187.89999999999998, 157, 212, 196.5, 211.9, 212.0, 212.0, 18.148820326678766, 84.85991379310344, 2.747135889292196], "isController": false}, {"data": ["HTTP Request - fish", 10, 0, 0.0, 169.89999999999998, 147, 189, 172.5, 188.4, 189.0, 189.0, 20.0, 93.4765625, 3.515625], "isController": false}, {"data": ["HTTP Request- currencies", 10, 0, 0.0, 274.7, 242, 504, 247.0, 480.4000000000001, 504.0, 504.0, 9.643201542912246, 191.46086969623917, 1.4690814850530378], "isController": false}, {"data": ["HTTP Request - usermanual", 20, 0, 0.0, 69.7, 26, 123, 67.0, 118.00000000000003, 122.8, 123.0, 71.68458781362007, 5046.727990591397, 10.53567428315412], "isController": false}, {"data": ["HTTP Request - propertiesReference", 10, 0, 0.0, 95.1, 64, 170, 85.0, 166.20000000000002, 170.0, 170.0, 14.204545454545453, 4152.762673117898, 2.1917169744318183], "isController": false}, {"data": ["HTTP Request - Home", 10, 0, 0.0, 2016.9, 1743, 2332, 2010.5, 2329.1, 2332.0, 2332.0, 3.9968025579536373, 368.22885441646685, 0.6557254196642687], "isController": false}, {"data": ["HTTP Request - Batches", 10, 0, 0.0, 118.39999999999999, 54, 217, 124.0, 213.20000000000002, 217.0, 217.0, 8.27814569536424, 1225.2528714817881, 1.0751888451986755], "isController": false}, {"data": ["HTTP Request - confirmation", 10, 0, 0.0, 401.8, 375, 427, 406.5, 425.7, 427.0, 427.0, 14.705882352941176, 83.0078125, 1.9244025735294117], "isController": false}, {"data": ["HTTP Request - changes", 10, 0, 0.0, 429.40000000000003, 90, 752, 429.0, 751.3, 752.0, 752.0, 12.165450121654501, 383.74629333941607, 1.591963199513382], "isController": false}, {"data": ["HTTP Request - addToCart", 10, 0, 0.0, 160.10000000000002, 146, 167, 164.5, 166.9, 167.0, 167.0, 21.459227467811157, 112.03225590128754, 3.77212982832618], "isController": false}, {"data": ["HTTP Request - charts", 10, 0, 0.0, 253.1, 241, 272, 251.0, 271.0, 272.0, 272.0, 9.615384615384617, 291.58841646634613, 1.3991135817307692], "isController": false}, {"data": ["HTTP Request - udemy", 10, 0, 0.0, 447.5, 279, 1317, 363.0, 1223.7000000000003, 1317.0, 1317.0, 7.347538574577516, 1087.5096149430565, 0.9543189750183688], "isController": false}, {"data": ["HTTP Request - practice", 10, 0, 0.0, 378.9, 340, 455, 351.0, 454.2, 455.0, 455.0, 6.153846153846154, 562.9747596153846, 0.9915865384615384], "isController": false}, {"data": ["HTTP Request  - vacation", 10, 0, 0.0, 778.9, 491, 1154, 711.5, 1140.9, 1154.0, 1154.0, 7.434944237918216, 24.316043215613384, 0.951150092936803], "isController": false}, {"data": ["HTTP Request - converters", 10, 0, 0.0, 258.6, 245, 273, 260.0, 272.8, 273.0, 273.0, 12.578616352201259, 289.50471698113205, 1.8794221698113207], "isController": false}, {"data": ["HTTP Request - signin", 10, 0, 0.0, 891.5, 718, 1126, 820.0, 1125.8, 1126.0, 1126.0, 6.605019815059445, 29.96382719616909, 1.0320343461030383], "isController": false}, {"data": ["HTTP Request - choose flight", 10, 0, 0.0, 440.2, 366, 625, 404.0, 615.1, 625.0, 625.0, 13.605442176870747, 96.26116071428572, 1.7139668367346939], "isController": false}, {"data": ["HTTP Request - courses", 10, 0, 0.0, 75.9, 27, 159, 75.0, 152.70000000000002, 159.0, 159.0, 7.633587786259541, 1129.8492664599237, 0.9914718511450381], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["Non HTTP response code: java.net.MalformedURLException/Non HTTP response message: unknown protocol: https:", 10, 100.0, 4.0], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 250, 10, "Non HTTP response code: java.net.MalformedURLException/Non HTTP response message: unknown protocol: https:", 10, "", "", "", "", "", "", "", ""], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": ["", 10, 10, "Non HTTP response code: java.net.MalformedURLException/Non HTTP response message: unknown protocol: https:", 10, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
