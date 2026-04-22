function Browser(name, version) {
    this.name = name
    this.version = version

    this.aboutBrowser = function() {
        console.log(this.name+ ", " +this.version)
        
    }
}

let myBrowser = new Browser("Microsoft Internet Explorer", "9.0")

myBrowser.aboutBrowser()