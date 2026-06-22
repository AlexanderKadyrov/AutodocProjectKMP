import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync
import SharedLogic
import SwiftUI

struct ContentView: View {

    @StateViewModel
    var viewModel = NewsViewModel()

    var body: some View {
        List {
            ForEach(viewModel.news, id: \.self) { model in
                NewsComponentView(model: model)
                    .listRowInsets(.init(.zero))
                    .listRowSeparator(.hidden)
                    .padding(.all, 16)
            }
        }
        .listStyle(.plain)
        .onAppear {
            viewModel.fetchNews(offset: 1, limit: 15)
        }
    }
}
