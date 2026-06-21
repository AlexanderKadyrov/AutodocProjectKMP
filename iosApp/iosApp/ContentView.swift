import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync
import SharedLogic
import SwiftUI

struct ContentView: View {

    @StateViewModel
    var viewModel = NewsViewModel()

    var body: some View {
        ZStack {
            ForEach(viewModel.news, id: \.self) { item in
                Text(item.title)
            }
        }
        .onAppear {
            viewModel.fetchNews(offset: 0, limit: 15)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}