package kr.co.gadaga.official.data.model.skt

data class Geometry (
    val type: String,
    val coordinates: List<Any>
)

/*
    "geometry": {
        "type": "Point",
        "coordinates": [126.97377427257477, 37.56502144018527 ]
    },
    =====================================================================================
    "geometry": {
        "type": "LineString",
        "coordinates": [[126.97377427257477,37.56502144018527 ],[126.97364372451413,37.565176975313314 ],[126.97351873386124,37.56524918689666 ]]
    },
*/