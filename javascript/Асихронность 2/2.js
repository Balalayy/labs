
// Асинхронные функции
function readConfig(name, callback) {
    setTimeout(() => {
        console.log('(1) config from ' + name + ' loaded')
        callback()
    }, Math.floor(Math.random() * 1000))
}

function doQuery(statement, callback) {
    setTimeout(() => {
        console.log('(2) SQL query executed: ' + statement)
        callback()
    }, Math.floor(Math.random() * 1000))
}

function httpGet(url, callback) {
    setTimeout(() => {
        console.log('(3) Page retrieved: ' + url)
        callback()
    }, Math.floor(Math.random() * 1000))
}

function readFile(path, callback) {
    setTimeout(() => {
        console.log('(4) Readme file from ' + path + ' loaded')
        callback()
    }, Math.floor(Math.random() * 1000))
}

function callback() {
    console.log('It is done!')
}

// Вызов функций


async function runTasks() {
    console.log('start')
    
    await readConfig('MyConfig')
    await doQuery('select * from cities')
    await httpGet('http://google.com')
    await readFile('README.md')
    
    console.log('end')
}

// Запускаем
runTasks()