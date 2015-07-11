import os, re, commands, sys

def openFile():
	f = open('input.csv', 'w+')
	return f

def closeFile(file):
	file.close()

def listProjects(directory):
	return [d for d in os.listdir(directory) if os.path.isdir(os.path.join(directory, d))]


def listVersionProjects(directory):
	dirs = [directory+d+"/" for d in os.listdir(directory) if os.path.isdir(os.path.join(directory, d))]
	return dirs
	

def execCloc(projectName, pathProject, version):

	comando = "cloc  --match-f='^*.java' "+ pathProject+" --csv "
	conteudo = commands.getoutput(comando)
	
	#explodir a saida do cloc na quebra de linha
	csv = conteudo.split('\n')
	loc = 0
	for row in csv:
		if "Java" in row:
			loc = row.split(',')[-1]
			break

	#print projectName, version, loc

	print projectName+";"+ version+";"+pathProject+";"+str(loc)+";"
	file.write(projectName+";"+ version+";"+pathProject+";"+str(loc)+";\n")

	return loc


if __name__ == "__main__":

	defaultDir = '/home/thiago/git/Projetos/'

	#diretorio que contem os projetos a serem computados pelo cloc.
	pathDir = ''
	
	if len(sys.argv) is 2:
		dir = str(sys.argv[1])
		if os.path.isdir(dir):
			pathDir = dir
		else:
			pathDir = defaultDir
	else:
		pathDir = defaultDir


	file = openFile()


	projects = listProjects(pathDir)

	#print projects
	loc = 0
	for project in projects:
		allVersionProjects = listProjects(defaultDir+project)
		allVersionProjects.sort()

		for version in allVersionProjects:
			pathProject = pathDir+project+"/"+version+"/"
			loc += int(execCloc(project, pathProject, version))

	#print "Total Lines of Code:", loc

	closeFile(file)