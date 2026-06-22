import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync
import SharedLogic
import SwiftUI

struct ContentView: View {
    
    @StateViewModel
    private var viewModel = NewsViewModel()
    
    @State
    private var path: [Route] = []
    
    var body: some View {
        NavigationStack(path: $path) {
            List {
                ForEach(viewModel.news, id: \.self) { model in
                    NewsComponentView(model: model)
                        .listRowInsets(.init(.zero))
                        .listRowSeparator(.hidden)
                        .padding(.all, 16)
                        .onTapGesture {
                            guard let url = URL(string: model.fullUrl) else { return }
                            path.append(.detail(url))
                        }
                }
            }
            .listStyle(.plain)
            .onAppear {
                viewModel.fetchNews(offset: 1, limit: 15)
            }
            .navigationTitle("News")
            .navigationDestination(for: Route.self) { route in
                switch route {
                case .detail(let url):
                    LegacyWebView(url: url)
                }
            }
        }
    }
}
