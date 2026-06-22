import SwiftUI
import UIKit

final class ImageCache {
    
    private enum Constants {
        static let fiftyMegabyteLimit = 50 * 1024 * 1024
        static let countLimit = 100
    }
    
    nonisolated(unsafe) static let shared = NSCache<NSURL, UIImage>()
    
    init() {
        ImageCache.shared.totalCostLimit = Constants.fiftyMegabyteLimit
        ImageCache.shared.countLimit = Constants.countLimit
    }
}
