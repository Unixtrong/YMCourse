# git 常用命令


- 初始化 git，只有初始化过的项目才能用 `git` 工具进行管理
```
git init
```

- 查看 `git` 当前状态
```
git status
```

- 添加修改，从工作区到暂存区
```
git add a.txt
git add files/c.txt
```

- 将修改从暂存区移至版本区，需要填写提交日志
```
git commit
```

- 查看历史提交日志
```
git log
```

- 查看某一次提交的详细修改
```
git show
git show ud8hh24h4gy3u48rdj2k4
```

- 将本地项目与远端项目关联
```
git remote add origin git@github.com:YourName/YourProject.git
```

- 拉取远端最新修改
```
git fetch
```

- 将本地版本库基于远端库重新提交
```
git rebase
```

- 将本地新的提交上传至远端
```
git push -u origin master
```

- 查看工作区改动
```
git diff a.txt
git diff
```

- 查看暂存区改动
```
git diff --cached
```

- 清除工作区改动
```
git checkout a.txt
git checkout .
```

- 将暂存区改动回退至工作区
```
git reset HEAD a.txt
git reset HEAD .
```

- 清除暂存区和工作区的内容
```
git reset HEAD --hard
```

- 将最后 n 次提交回退至工作区
```
git reset HEAD^^ // 2次提交
git reset HEAD~3 // 3次提交
```

- 将最后 n 次提交清除（工作区也删除）
```
git reset HEAD^^ --hard
```

- 将某一次提交回滚（会生成新的回滚提交）
```
git revert sdlkfn3r4kn3gjtykt
```