from django.shortcuts import render
from rest_framework.views import APIView
from .models import Feed
# Create your views here.
class Main(APIView):
    def get(self, request):
        feed_list = Feed.objects.all().order_by('-id') # 모델이 선언한 피드 테이블의 모든 데이터를 가져옴 역순으로 가져오기 위한 order by -id

        return render(request, 'Kiistargram/main.html', context=dict(feed_list=feed_list))