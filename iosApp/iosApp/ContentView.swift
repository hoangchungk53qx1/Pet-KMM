import SwiftUI
import common

struct ContentView: View {
    var body: some View {
        TabView {
            HomeView()
                .tabItem { Label("Home111", systemImage: "person") }
            FavoriteView()
                .tabItem { Label("Favorite", systemImage: "clock") }
            SettingView()
                .tabItem { Label("Setting", systemImage: "list.number") }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
