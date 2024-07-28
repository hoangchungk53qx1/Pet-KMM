import SwiftUI
import common

@main
struct iOSApp: App {
    
  init() {
      KoinDepsKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
