package kr.co.gadaga.official.data.model.skt

data class Feature (
    val type: String,
    val geometry: Geometry,
    val properties: Properties
)
/*
{"type": "Feature",
    "geometry": {
        "type": "Point",
        "coordinates": [126.97377427257477, 37.56502144018527 ]
        },
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
    {"type": "Feature",
    "geometry": {
        "type": "LineString",
        "coordinates": [[126.97377427257477,37.56502144018527 ],[126.97364372451413,37.565176975313314 ],[126.97351873386124,37.56524918689666 ]]
        },
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