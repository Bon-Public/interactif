// Form inputs

const requestUrl = "api/effects/mask/pitterboxing"

const valuesDiv = document.getElementById("pitter-values");


let pitterboxingValues = {}

async function main() {
    // Requests the local api with the barcode number
    fetch(requestUrl, {
        method: "GET", 
        //body: JSON.stringify(data)
        })
        .then(res => res.json())
        .then((data) => {
            appendValues(data)
            return data
        })
}

function appendValues(data) {
    valuesDiv.innerHTML = "<p>sumPillarboxing : "+data.sumPillarboxing+"</p><p>sumLetterboxing : "+data.sumLetterboxing+"</p>"
    
}

function letterboxingIncrement() {
    await main().then((data) => {
        console.log("DATA : " + data)
    })

}


// Init
main()