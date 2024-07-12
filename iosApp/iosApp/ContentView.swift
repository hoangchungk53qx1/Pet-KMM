import SwiftUI
import common

struct ContentView: View {
	let greet = Greeting().greet()

     let ss = "Android is best in the world"
	var body: some View {
		Text(ss)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}