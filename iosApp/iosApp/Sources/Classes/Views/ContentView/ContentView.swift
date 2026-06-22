import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync
import SharedLogic
import SwiftUI

struct ContentView: View {
    
    @Environment(\.openURL) private var openURL

    @StateViewModel
    private var viewModel = NewsViewModel()

    var body: some View {
        List {
            ForEach(viewModel.news, id: \.self) { model in
                NewsComponentView(model: model)
                    .listRowInsets(.init(.zero))
                    .listRowSeparator(.hidden)
                    .padding(.all, 16)
                    .onTapGesture {
                        guard let url = URL(string: model.fullUrl) else { return }
                        openURL(url)
                    }
            }
        }
        .listStyle(.plain)
        .onAppear {
            viewModel.fetchNews(offset: 1, limit: 15)
        }
    }
}
