import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync
import SharedLogic
import SwiftUI

struct NewsListView: View {
    
    @StateViewModel
    private var viewModel = NewsViewModel(provider: NewsNetworkProvider())
    
    let clickable: (String) -> Void
    
    var body: some View {
        List {
            ForEach(viewModel.newsViewModels, id: \.self) { viewModel in
                NewsComponentView(viewModel: viewModel) {
                    viewModel.tapFavorite()
                } onTapAction: {
                    clickable(viewModel.entity.fullUrl)
                }
                .listRowInsets(.init(.zero))
                .listRowSeparator(.hidden)
                .padding(.all, 16)
            }
        }
        .listStyle(.plain)
        .onAppear {
            viewModel.fetchNews(offset: 1, limit: 15)
        }
        .navigationTitle("News")
    }
}
