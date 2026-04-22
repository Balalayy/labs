function ask_password(login, password, success, failure) {
    login = login.toLowerCase()
    password = password.toLowerCase()

    vowels = new Set(['a', 'e', 'i', 'o', 'u', 'y'])

    function stringAnalyze(str) {
        let vowelsCount = 0
        let consonants = []

        for (let char of str) {
            if (vowels.has(char)) {
                vowelsCount++
            } else if (char >= 'a' && char <= 'z') {
                consonants.push(char)
            }
        }

        return{vowelsCount: vowelsCount, consonants: consonants}
    }

    loginAnalysis = stringAnalyze(login)
    passwordAnalysis = stringAnalyze(password)

    vowelsCorrect = passwordAnalysis.vowelsCount === 3
    consonantsCorrect = loginAnalysis.consonants.join('') === passwordAnalysis.consonants.join('')

    if (vowelsCorrect && consonantsCorrect) {
        success(login)
    } else if (!vowelsCorrect && !consonantsCorrect) {
        failure(login, "Everything is wrong")
    } else if (!vowelsCorrect) {
        failure(login, "Wrong number of vowels")
    } else {
        failure(login, "Wrong consonants")
    }
}

function main(login, password) {
    ask_password(
        login, 
        password,
        (login) => {console.log(`Привет, ${login}!`)},
        (login, error) => console.log(`Кто-то пытался притвориться пользователем ${login}, но в пароле допустил ошибку: ${error}`)
        
    )
}

main("login", "aaalgn")
main("login", "nigol")
main("login", "lgn")
main("login", "aaalnx")