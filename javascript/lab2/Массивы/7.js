let array = ['c', 5, 2, 'b', 3, 1, 4, 'a']

array.sort((a, b) => {
    if (typeof a !== typeof b) {
        return typeof a === 'number' ? -1 : 1
    }
    return a > b ? 1 : -1
})

console.log(array)