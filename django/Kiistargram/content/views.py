from django.shortcuts import render
from rest_framework.response import Response
from rest_framework.views import APIView
from .models import Feed
import os
from uuid import uuid4
from Kiistargram.settings import MEDIA_ROOT
# Create your views here.
class Main(APIView):
    def get(self, request):
        feed_list = Feed.objects.all().order_by('-id') # 모델이 선언한 피드 테이블의 모든 데이터를 가져옴 역순으로 가져오기 위한 order by -id

        return render(request, 'Kiistargram/main.html', context=dict(feed_list=feed_list))

class UploadFeed(APIView):
    def post(self, request):
        file = request.FILES['file']

        uuid_name = uuid4().hex
        save_path = os.path.join(MEDIA_ROOT, uuid_name)

        with open(save_path, 'wb+') as destination:
            for chuck in file.chunks():
                destination.write(chuck)

        image = uuid_name
        content = request.data.get('content')
        user_id = request.data.get('user_id')
        profile_image = request.data.get('profile_image')
        Feed.objects.create(image=image, content=content, user_id=user_id, profile_image=profile_image, like_count=0)
        return Response(status=200)