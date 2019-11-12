package kr.co.gadaga.official.data.model.skt

data class Properties (
    val totalDistance: Int,
    val totalTime: Int,
    val time: Int,
    val name: String,
    val distance: Int,
    val description: String,
    val index: Int
)
/*
    "properties":{
        "totalDistance": 1008, /meter
        "totalTime": 836, /second
        "index": 0,
        "pointIndex": 0,
        "name": "",
        "description": "덕수궁길 을 따라 34m 이동",
        "direction": "",
        "nearPoiName": "",
        "nearPoiX": "0.0",
        "nearPoiY": "0.0",
        "intersectionName": "",
        "facilityType": "1",
        "facilityName": "",
        "turnType": 200,
        "pointType": "SP"
        }
    },
    =====================================================================================
    "properties":{
        "index": 1,
        "lineIndex": 0,
        "name": "덕수궁길",
        "description": "덕수궁길, 34m",
        "distance": 34,
        "time": 25,
        "roadType": 0,
        "categoryRoadType": 0,
        "facilityType": "1",
        "facilityName": ""
        }
    },
*/