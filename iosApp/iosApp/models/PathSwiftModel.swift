//
//  PathSwiftModel.swift
//  iosApp
//
//  Created by ws-071-11b on 2/8/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

struct PathSwiftModel {
    let path: [PathEnum]
}

enum PathEnum {
    case LEFT
    case RIGHT
    case TOP
    case BOTTOM
    case DROP
}
