#include <iostream>
#include <map>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;

struct nextNode {
	int node;
	int dist;
};

bool compare(pair<int, vector<nextNode>> a, pair<int, vector<nextNode>> b) {
	return a.first < b.first;
}

map<int, vector<nextNode>> m;
queue<pair<int, int>> q;
bool visited[100001];

nextNode BFS() {
	int max_dist = 0, max_v;

	while (!q.empty()) {
		int i = q.front().first;
		int dist = q.front().second;

		if (dist > max_dist) {
			max_dist = dist;
			max_v = i;
		}

		vector<nextNode> vec = m.find(i)->second;
		for (int j = 0; j < vec.size(); j++) {
			int next_node = vec[j].node;
			int next_dist = vec[j].dist;

			if (!visited[next_node]) {
				visited[next_node] = true;
				q.push(make_pair(next_node, dist + next_dist));
			}
		}
		q.pop();
	}

	return { max_v, max_dist };
}

int main() {
	int V;
	scanf("%d", &V);

	for (int v = 0; v < V; v++) {
		int vertex;
		scanf("%d", &vertex);
		vector<nextNode> temp_vec;

		while (true) {
			int node, dist;
			scanf("%d", &node);
			if (node == -1) break;
			scanf("%d", &dist);
			struct nextNode temp_node = { node, dist };
			temp_vec.push_back(temp_node);
		}
		m.insert(make_pair(vertex, temp_vec));
	}
	visited[1] = true;
	q.push(make_pair(1, 0));
	int max_v = BFS().node; // 한 정점으로부터 거리가 최대인 정점 구하기

	q = queue<pair<int, int>>();
	fill(&visited[0], &visited[100001], 0); // visited, queue 초기화

	visited[max_v] = true;
	q.push(make_pair(max_v, 0));
	int max_dist = BFS().dist; // 거리가 최대인 정점에서 다시 거리가 최대인 정점 구하기

	printf("%d", max_dist);

	return 0;
}