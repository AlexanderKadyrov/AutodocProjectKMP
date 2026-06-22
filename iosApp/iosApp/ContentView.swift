import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync
import SharedLogic
import SwiftUI

struct ContentView: View {

    @StateViewModel
    var viewModel = NewsViewModel()

    var body: some View {
        VStack {
            ForEach(viewModel.news, id: \.self) { item in
                Text(item.title)
            }
        }
        .onAppear {
            viewModel.fetchNews(offset: 1, limit: 15)
        }
    }
}
