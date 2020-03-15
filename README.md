# Balanced Brackets

## App to check if the pair of brackets are balanced 

### Works with:  "{}", "[]", "()"
### Requeriments: Just docker

### How to build and run the app on UNIX based OS (MacOS, Linux):
	>./build_and_run_docker.sh 

### How to run using Windows:
	> docker build -t balanced-brackets .

### How to run using Windows:
	> docker run -it --rm --name balanced-brackets-app balanced-brackets

### Inputs tested:
- (): valid
- (: not valid
- [](){}: valid
- [({: not valid
- ]}): not valid
- (){}[]: valid	
- [{()}](){}: valid
- []{(): not valid
- [{)]: not valid
- [{(({{[[]]}}))}]: valid
- [{(({{[[]]})))}]: not valid
- [{{({{[[]]}}))}]: not valid
