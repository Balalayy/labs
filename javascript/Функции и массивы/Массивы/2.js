let countries = ["Бразилия", "Индия", "Китай"]
let population = [250654621, 9999999999, 1111111111]

function country () {

    for (let i = 0; i < countries.length; i++) {
        console.log(`${countries[i]} — ${population[i].toLocaleString()}`)
    }

    for (let i in countries) {
        console.log(`${countries[i]} — ${population[i].toLocaleString()}`)
    }
    
}

country()
