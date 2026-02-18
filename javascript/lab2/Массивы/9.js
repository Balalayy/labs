let arr1 = [1, 2, 5, 4, 6]
let arr2 = [8, 2, 5 ,9, 5]

let superArr = arr1.concat(arr2)
let mediana
let length = superArr.length

if (length % 2 === 1) {
    mediana = superArr[Math.floor(length / 2)]
} else {
    let mid1 = superArr[length / 2 - 1]
    let mid2 = superArr[length / 2]
    mediana = (mid1 + mid2) / 2
}

console.log(superArr)
console.log(mediana)