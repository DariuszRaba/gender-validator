#simple gender validator application

Application guess gender of provided person.
-Male,
-Female,
-Inconclusive when it can't guess

There are two endpoints:
- gender/tokens   -> application return all tokens grouped for male and female category
- gender/check/{variant}/{person}   -> application return gender type

*{variant} as variant put "first" or "all"
*{person} as person you put persons names 

EXAMPLES:

![all-tokens](https://user-images.githubusercontent.com/57062542/112619232-5cfec000-8e27-11eb-82a1-a9768567a8f5.png)

![gv](https://user-images.githubusercontent.com/57062542/112622007-b4eaf600-8e2a-11eb-881c-438ac496507a.png)

![gv2](https://user-images.githubusercontent.com/57062542/112622023-bae0d700-8e2a-11eb-8e31-d647c20cf4ad.png)

![gv3](https://user-images.githubusercontent.com/57062542/112622041-c2a07b80-8e2a-11eb-8c5e-4d028656b938.png)
