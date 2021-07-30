//
//  ContentView.swift
//  GitSpyTest
//
//  Created by Tarsha de Souza on 29/7/21.
//

import SwiftUI
import sharedKMP

struct ContentView: View {
    var body: some View {
        Text("Hello, world!")
            .padding()
        let greet = Greeting().greeting()
        Text(greet)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
