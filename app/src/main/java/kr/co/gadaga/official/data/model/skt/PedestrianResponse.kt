package kr.co.gadaga.official.data.model.skt

data class PedestrianResponse (
    val type: String,
    val features: List<Feature>
)

/*
{
"type": "FeatureCollection",
"features": [
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
    =====================================================================================
    {"type": "Feature",
    "geometry": {
        "type": "Point",
        "coordinates": [126.97351873386124,37.56524918689666 ]
        },
    "properties":{
        "index": 2,
        "pointIndex": 1,
        "name": "",
        "description": "좌회전 후 덕수궁길 을 따라 11m 이동 ",
        "direction": "",
        "nearPoiName": "",
        "nearPoiX": "0.0",
        "nearPoiY": "0.0",
        "intersectionName": "",
        "facilityType": "1",
        "facilityName": "",
        "turnType": 12,
        "pointType": "GP"
        }
    },
    =====================================================================================
    {"type": "Feature",
    "geometry": {
        "type": "LineString",
        "coordinates": [[126.97351873386124,37.56524918689666 ],[126.97348818258386,37.56519641470728 ],[126.97346318572683,37.56516586225602 ]]
        },
    "properties":{
        "index": 3,
        "lineIndex": 1,
        "name": "덕수궁길",
        "description": "덕수궁길, 11m",
        "distance": 11,
        "time": 8,
        "roadType": 0,
        "categoryRoadType": 0,
        "facilityType": "1",
        "facilityName": ""
        }
    },
    =====================================================================================
    {"type": "Feature",
    "geometry": {
        "type": "Point",
        "coordinates": [126.97346318572683,37.56516586225602 ]     },     "properties":{      "index": 4,      "pointIndex": 2,      "name": "",      "description": "우회전 후 보행자도로 을 따라 15m 이동 ",      "direction": "",      "nearPoiName": "",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 13,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97346318572683,37.56516586225602 ],[126.97337430525273,37.56515475084269 ],[126.97330208866867,37.565188079005196 ]        ]     },     "properties":{      "index": 5,      "lineIndex": 2,      "name": "보행자도로",      "description": "보행자도로, 15m",      "distance": 15,      "time": 12,      "roadType": 0,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97330208866867,37.565188079005196 ]     },     "properties":{      "index": 6,      "pointIndex": 3,      "name": "",      "description": "좌회전 후 서소문로11길 을 따라 282m 이동 ",      "direction": "",      "nearPoiName": "",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 12,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97330208866867,37.565188079005196 ],[126.97282435851817,37.565043642786904 ],[126.9727771422501,37.56498531538906 ],[126.9727715885372,37.564938098557654 ],[126.97281603380534,37.564765897156406 ],[126.97284381196035,37.56466313182653 ],[126.97287159035118,37.5645520341322 ],[126.97288270453744,37.56440760668122 ],[126.9728938188023,37.56426040177539 ],[126.97287716882572,37.5637243526974 ],[126.97293273189557,37.563279960923104 ],[126.97301884482803,37.56293833552475 ]        ]     },     "properties":{      "index": 7,      "lineIndex": 3,      "name": "서소문로11길",      "description": "서소문로11길, 282m",      "distance": 282,      "time": 217,      "roadType": 22,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97301884482803,37.56293833552475 ]     },     "properties":{      "index": 8,      "pointIndex": 4,      "name": "파리바게뜨 서소문중앙",      "description": "파리바게뜨 서소문중앙 에서 좌회전 후 서소문로 을 따라 43m 이동 ",      "direction": "",      "nearPoiName": "파리바게뜨 서소문중앙",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 12,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97301884482803,37.56293833552475 ],[126.97334103587943,37.56300222276385 ],[126.97337158849336,37.563007778221426 ],[126.97347991085421,37.563046664531605 ]        ]     },     "properties":{      "index": 9,      "lineIndex": 4,      "name": "서소문로",      "description": "서소문로, 43m",      "distance": 43,      "time": 30,      "roadType": 22,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97347991085421,37.563046664531605 ]     },     "properties":{      "index": 10,      "pointIndex": 5,      "name": "던킨도너츠 서소문점",      "description": "던킨도너츠 서소문점 에서 우측 횡단보도 후 보행자도로 을 따라 27m 이동 ",      "direction": "",      "nearPoiName": "던킨도너츠 서소문점",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "11",      "facilityName": "",      "turnType": 213,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97347991085421,37.563046664531605 ],[126.97357435329518,37.56281336002049 ]        ]     },     "properties":{      "index": 11,      "lineIndex": 5,      "name": "보행자도로",      "description": "보행자도로, 27m",      "distance": 27,      "time": 48,      "roadType": 21,      "categoryRoadType": 0,      "facilityType": "11",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97357435329518,37.56281336002049 ]     },     "properties":{      "index": 12,      "pointIndex": 6,      "name": "외환은행 서소문지점",      "description": "외환은행 서소문지점 에서 우회전 후 서소문로 을 따라 29m 이동 ",      "direction": "",      "nearPoiName": "외환은행 서소문지점",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 13,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97357435329518,37.56281336002049 ],[126.97331882314968,37.56273836415756 ],[126.97326049521064,37.562735585656675 ]        ]     },     "properties":{      "index": 13,      "lineIndex": 6,      "name": "서소문로",      "description": "서소문로, 29m",      "distance": 29,      "time": 21,      "roadType": 21,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97326049521064,37.562735585656675 ]     },     "properties":{      "index": 14,      "pointIndex": 7,      "name": "외환은행 서소문지점",      "description": "외환은행 서소문지점 에서 좌회전 후 32m 이동 ",      "direction": "",      "nearPoiName": "외환은행 서소문지점",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 12,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97326049521064,37.562735585656675 ],[126.97334105120727,37.56246061907409 ]        ]     },     "properties":{      "index": 15,      "lineIndex": 7,      "name": "",      "description": ", 32m",      "distance": 32,      "time": 25,      "roadType": 21,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97334105120727,37.56246061907409 ]     },     "properties":{      "index": 16,      "pointIndex": 8,      "name": "동화산업",      "description": "동화산업 에서 우회전 후 52m 이동 ",      "direction": "",      "nearPoiName": "동화산업",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 13,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97334105120727,37.56246061907409 ],[126.97312996224208,37.56235784946 ],[126.97295498337674,37.5621745343037 ],[126.97290776616508,37.56214953636352 ]        ]     },     "properties":{      "index": 17,      "lineIndex": 8,      "name": "",      "description": ", 52m",      "distance": 52,      "time": 40,      "roadType": 0,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97290776616508,37.56214953636352 ]     },     "properties":{      "index": 18,      "pointIndex": 9,      "name": "르호봇프라임 시청센터",      "description": "르호봇프라임 시청센터 에서 좌회전 후 세종대로9길 을 따라 247m 이동 ",      "direction": "",      "nearPoiName": "르호봇프라임 시청센터",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 12,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97290776616508,37.56214953636352 ],[126.97296887296501,37.56210509818223 ],[126.97305497945186,37.5619912240787 ],[126.97312719957303,37.56183291044894 ],[126.97350218057109,37.56129686839254 ],[126.97364105947624,37.56120243741906 ],[126.97370216887003,37.56106634322847 ],[126.97380493901152,37.56100524106533 ],[126.97391604172698,37.560944139051635 ],[126.97422990680789,37.56077471993597 ],[126.97449655357676,37.560619187247624 ],[126.97456321652659,37.560535864798275 ],[126.97458266029959,37.560496980779355 ],[126.97459099365958,37.56046920638051 ],[126.97459377149863,37.560458096611 ]        ]     },     "properties":{      "index": 19,      "lineIndex": 9,      "name": "세종대로9길",      "description": "세종대로9길, 247m",      "distance": 247,      "time": 183,      "roadType": 22,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97459377149863,37.560458096611 ],[126.97459932772695,37.56041643488819 ],[126.97459932953473,37.56035255342711 ],[126.97459655263887,37.56033033373866 ],[126.9745937758216,37.560305336595384 ],[126.97458822132246,37.56028589431195 ],[126.9745271181379,37.560202569571175 ],[126.97442990752569,37.560105356908686 ],[126.97434380606893,37.56004147390341 ],[126.9742327069688,37.559974812995 ],[126.97420770940406,37.559969257637036 ],[126.97417437918672,37.559966479584475 ],[126.97405216802305,37.5599692548476 ],[126.97398272990652,37.55996925360232 ],[126.97392995693797,37.55996925265591 ]        ]     },     "properties":{      "index": 20,      "lineIndex": 10,      "name": "칠패로",      "description": "칠패로, 93m",      "distance": 93,      "time": 66,      "roadType": 21,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97392995693797,37.55996925265591 ]     },     "properties":{      "index": 21,      "pointIndex": 10,      "name": "",      "description": "우측 횡단보도 후 9m 이동 ",      "direction": "",      "nearPoiName": "",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "11",      "facilityName": "",      "turnType": 213,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97392995693797,37.55996925265591 ],[126.97387440833104,37.55990259274376 ]        ]     },     "properties":{      "index": 22,      "lineIndex": 11,      "name": "",      "description": ", 9m",      "distance": 9,      "time": 36,      "roadType": 21,      "categoryRoadType": 0,      "facilityType": "11",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97387440833104,37.55990259274376 ]     },     "properties":{      "index": 23,      "pointIndex": 11,      "name": "",      "description": "직진 후 5m 이동 ",      "direction": "",      "nearPoiName": "",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 11,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97387440833104,37.55990259274376 ],[126.97384107889965,37.5598720401429 ]        ]     },     "properties":{      "index": 24,      "lineIndex": 12,      "name": "",      "description": ", 5m",      "distance": 5,      "time": 4,      "roadType": 21,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97384107889965,37.5598720401429 ]     },     "properties":{      "index": 25,      "pointIndex": 12,      "name": "",      "description": "횡단보도 후 보행자도로 을 따라 25m 이동 ",      "direction": "",      "nearPoiName": "",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "11",      "facilityName": "",      "turnType": 211,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97384107889965,37.5598720401429 ],[126.97390496809724,37.559655399811724 ]        ]     },     "properties":{      "index": 26,      "lineIndex": 13,      "name": "보행자도로",      "description": "보행자도로, 25m",      "distance": 25,      "time": 46,      "roadType": 21,      "categoryRoadType": 0,      "facilityType": "11",      "facilityName": ""     }    },    {"type": "Feature",     "geometry": {       "type": "Point",       "coordinates": [126.97390496809724,37.559655399811724 ]     },     "properties":{      "index": 27,      "pointIndex": 13,      "name": "올림푸스존 남대문점",      "description": "올림푸스존 남대문점 에서 우회전 후 칠패로 을 따라 104m 이동 ",      "direction": "",      "nearPoiName": "올림푸스존 남대문점",      "nearPoiX": "0.0",      "nearPoiY": "0.0",      "intersectionName": "",      "facilityType": "1",      "facilityName": "",      "turnType": 13,      "pointType": "GP"     }    },    {"type": "Feature",     "geometry":        {       "type": "LineString",       "coordinates": [        [126.97390496809724,37.559655399811724 ],[126.97382441996065,37.559652620912395 ],[126.9735355582604,37.559622063728995 ],[126.97308837812606,37.55957483897758 ],[126.97305782535479,37.55957483842968 ],[126.97273007799502,37.55955539036849 ]        ]     },     "properties":{      "index": 28,      "lineIndex": 14,      "name": "칠패로",      "description": "칠패로, 104m",      "distance": 104,      "time": 75,      "roadType": 21,      "categoryRoadType": 0,      "facilityType": "1",      "facilityName": ""     }    },
    =====================================================================================
    {"type": "Feature",
    "geometry": {
        "type": "Point",
        "coordinates": [126.97273007799502,37.55955539036849 ]
        },
    "properties":{
        "index": 29,
        "pointIndex": 14,
        "name": """",
        "description": "도착",
        "direction": "",
        "nearPoiName": """",
        "nearPoiX": "0.0",
        "nearPoiY": "0.0",
        "intersectionName": """",
        "facilityType": "",
        "facilityName": "",
        "turnType": 201,
        "pointType": "EP"
        }
    }]
}

 */