package kr.co.gadaga.official.data.model.naver

data class Address (
    val roadAddress: String, // 도로명주소
    val jibunAddress: String, // 지번주소
    val englishAddress: String, // 영어주소
    val addressElements: List<AddressElement>, //
    val x: Double, // 경도
    val y: Double, // 위도
    val distance: Long // 검색 중심 좌표로부터의 거리(단위: 미터)
)
/*
{
    "roadAddress": "경상남도 거제시 연초면 효촌1길 10-1",
    "jibunAddress": "경상남도 거제시 연초면 연사리 93",
    "englishAddress": "10-1, Hyochon 1-gil, Yeoncho-myeon, Geoje-si, Gyeongsangnam-do, Republic of Korea",
    "addressElements": [
        {
            "types": ["SIDO"],
            "longName": "경상남도",
            "shortName": "경상남도",
            "code": ""
        },
        {
            "types": ["SIGUGUN"],
            "longName": "거제시",
            "shortName": "거제시",
            "code": ""
        },
        {
            "types": ["DONGMYUN"],
            "longName": "연초면",
            "shortName": "연초면",
            "code": ""
        },
        {
            "types": ["RI"],
            "longName": "연사리",
            "shortName": "연사리",
            "code": ""
        },
        {
            "types": ["ROAD_NAME"],
            "longName": "효촌1길",
            "shortName": "효촌1길",
            "code": ""
        },
        {
            "types": ["BUILDING_NUMBER"],
            "longName": "10-1",
            "shortName": "10-1",
            "code": ""
        },
        {
            "types": ["BUILDING_NAME"],
            "longName": "",
            "shortName": "",
            "code": ""
        },
        {
            "types": ["LAND_NUMBER"],
            "longName": "93",
            "shortName": "93",
            "code": ""
        },
        {
            "types": ["POSTAL_CODE"],
            "longName": "53209",
            "shortName": "53209",
            "code": ""
        }
    ],
    "x": "128.6521583",
    "y": "34.9070498",
    "distance": 0
}
*/