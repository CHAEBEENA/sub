package kr.co.gadaga.official.data.model.naver

data class GeocodeResponse (
    val status: String,
    val meta: Meta,
    val adresses: List<Address>,
    /**
     * 200 OK
     * 400 INVALID_REQUEST
     * 500 SYSTEM_ERROR
     */
    val errorMessage: String
)

/*
 {
    "status": "OK",
    "meta": { "totalCount": 1, "page": 1, "count": 1 },
    "addresses": [
        {
            "roadAddress": "경상남도 거제시 연초면 효촌1길 10-1",
            "jibunAddress": "경상남도 거제시 연초면 연사리 93",
            "englishAddress": "10-1, Hyochon 1-gil, Yeoncho-myeon, Geoje-si, Gyeongsangnam-do, Republic of Korea",
            "addressElements": [ ... ],
            "x": "128.6521583",
            "y": "34.9070498",
            "distance": 0
        },
        {...}
    ],
    "errorMessage": ""
}
 */