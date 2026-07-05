import SwiftUI

struct ContentView: View {
    
    @State
    private var path: [Route] = []
    
    var body: some View {
        NavigationStack(path: $path) {
            NewsListView { url in
                guard let url = URL(string: url) else { return }
                path.append(.detail(url))
            }
            .navigationDestination(for: Route.self) { route in
                switch route {
                case .detail(let url):
                    LegacyWebView(url: url)
                }
            }
        }
    }
}
