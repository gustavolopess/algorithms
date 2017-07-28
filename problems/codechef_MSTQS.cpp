// labels = kruskal, graph, mst, disjoint sets, minimal spanning tree
// problem link = https://www.codechef.com/problems/MSTQS

#include <bits/stdc++.h>
using namespace std;

typedef pair<int, int> ii;
typedef pair<int, ii> iii;
typedef vector<int> vi;
typedef vector<iii> viii;

#define rp(a,b,i) for(int i = a; i < b; i++)

int p[(int)2e3+5];
int omw[(int)2e3+5][(int)2e3+5]; // original map of weights
int cmw[(int)2e3+5][(int)2e3+5]; // changeable map of weights

void init_ds() {
	rp(0, (int)2e3+5, i) p[i] = i; // all vertice i is a parent of himself  
}


int find_parent(int i) {
	return p[i] == i ? i : p[i] = find_parent(p[i]);
}


void unit(int i, int j) {
	int pi = find_parent(i), pj = find_parent(j);
	p[pi] = pj;
}



int main() {
	int n, m, q, v, w, u, qt, mst_sum = 0, mst_sample;
	viii G;
	memset(omw, 0, sizeof omw);
	memset(cmw, 0, sizeof cmw);
	init_ds();
	vi mst_ws;
	cin >> n >> m >> q;
	
	while(m--) {
		cin >> u >> v >> w;
		G.push_back(iii(w, ii(u, v)));
		omw[u][v] = omw[v][u] = cmw[u][v] = cmw[v][u] = w;
	}
	sort(G.begin(), G.end());
	for(viii::iterator it = G.begin(); it != G.end(); ++it) {
		int weigh = it->first, ui = it->second.first, vi = it->second.second;
		if (find_parent(ui) != find_parent(vi)) {
			unit(ui, vi);
			mst_sum += weigh;
			mst_ws.push_back(weigh);
			mst_sample = ui;	
		}
	}
	
	while(q--) {
		cin >> qt;
		switch(qt) {
			case 1:
				cin >> u >> v;
				if (cmw[u][v] != 0 && find_parent(mst_sample) == find_parent(u) && find_parent(u) == find_parent(v)) {
					cmw[u][v] = cmw[v][u] = 0;				
					mst_sum -= omw[u][v];
				}
				break;
			case 2:
				cin >> u >> v;
				if (cmw[u][v] == 0 && find_parent(mst_sample) == find_parent(u) && find_parent(u) == find_parent(v)) {
					cmw[u][v] = cmw[v][u] = omw[u][v];
					mst_sum += omw[u][v];
				}
				break;
			case 3:
				cout << mst_sum << endl;
				break;
		}
	
	}
	

	return 0;
}
